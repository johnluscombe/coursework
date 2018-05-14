class ServicesController < ApplicationController
	def index
		@church = Church.find(params[:church_id])
		order_param = (params[:order] || :Day).to_sym
		@services = case order_param
		when :Day
			@church.services.sort_by {|service| Service::WeekMapping[service.day_of_week] || -1}
		when :Time
			@church.services.order(:start_time)
		end
	end

	def show
		@service = Service.find(params[:id])
		@ride = Ride.new
	end

	def new
		@church = Church.find(params[:church_id])
		@service = @church.services.build
	end

	def create
		@church = Church.find(params[:church_id])
		@service = @church.services.build(service_params)
		if @service.save
			flash[:success] = "Service created"
			redirect_to @service
		else
			flash.now[:danger] = "Unable to create service"
			render 'new'
		end
	end

	def edit
		@service = Service.find(params[:id])
	rescue
		flash[:danger] = "Unable to find service"
		redirect_to services_path
	end

	def update
		@service = Service.find(params[:id])
		if @service.update(service_params)
			flash[:success] = "Your profile has been modified"
			redirect_to @service
		else
			flash[:danger] = "Unable to update profile"
			render 'edit'
		end
	end

	def destroy
		@service = Service.find(params[:id])
		@service.destroy
		flash[:success] = "#{@service.name} removed from the site"
		redirect_to services_path
	end

	private

	def service_params
		params.require(:service).permit(:day_of_week,
			:start_time,
			:finish_time,
			:location,
			rides_attributes: [:date,
				:leave_time,
				:return_time,
				:number_of_seats,
				:seats_available,
				:meeting_location,
				:vehicle])
	end
end