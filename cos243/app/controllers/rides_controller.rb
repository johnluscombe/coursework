class RidesController < ApplicationController
	before_action :ensure_user_logged_in, only: [:new, :create, :edit, :update, :destroy]
	before_action :ensure_correct_user, only: [:edit, :destroy]

	def index
		@service = Service.find(params[:service_id])
		order_param = (params[:order] || :Date).to_sym
		ordering = case order_param
		when :Date
			:date
		when :Service
			:service_id
		end
		@rides = @service.rides.order(ordering)
	end

	def show
		@ride = Ride.find(params[:id])
	end

	def new
		@service = Service.find(params[:service_id])
		@ride = @service.rides.build
	end

	def create
		@service = Service.find(params[:service_id])
		@ride = @service.rides.build(ride_params)
		@ride.user = current_user
		if @ride.save
			flash[:success] = "Ride created"
			redirect_to @ride
		else
			flash.now[:danger] = "Unable to create ride"
			render 'new'
		end
	end

	def edit
		@ride = Ride.find(params[:id])
	rescue
		flash[:danger] = "Unable to find ride"
		redirect_to rides_path
	end

	def update
		@ride = Ride.find(params[:id])
		if !params[:add_to_users]
			if @ride.update(ride_params)
				flash[:success] = "Ride profile has been modified"
				redirect_to @ride
			else
				flash.now[:danger] = "Unable to update profile"
				render 'edit'
			end
		else
			@ride.users << current_user
			@ride.seats_available = @ride.seats_available - 1
			if @ride.save
				flash[:success] = "Successfully claimed ride"
			else
				flash[:danger] = "Unable to claim ride"
			end
			redirect_to @ride
		end
	end

	def destroy
		@ride = Ride.find(params[:id])
		@ride.destroy
		flash[:success] = "Ride removed from the site"
		redirect_to rides_path
	end

	private

	def ride_params
		params.require(:ride).permit(:date,
			:leave_time,
			:return_time,
			:number_of_seats,
			:seats_available,
			:meeting_location,
			:vehicle)
	end

	def ensure_user_logged_in
		unless current_user #If no user is logged in
			flash[:warning] = "Not logged in"
			redirect_to login_path
		end
  end

	def ensure_correct_user
		@ride = Ride.find(params[:id])
		@user = @ride.user
		unless current_user?(@user) #If the user does not match the one logged in
			flash[:danger] = "Cannot edit other user's rides"
	    redirect_to root_path
		end
	rescue #If the church cannot be found
		flash[:danger] = "Unable to find ride"
		redirect_to rides_path
  end
end
