class ChurchesController < ApplicationController
	before_action :ensure_user_logged_in, only: [:new, :create, :edit, :update, :destroy]
	before_action :ensure_correct_user, only: [:edit, :update, :destroy]

	def index
		@churches = Church.all
	end

	def show
		@church = Church.find(params[:id])
	rescue
		flash[:danger] = "Unable to find church"
		redirect_to churches_path
	end

	def new
		@church = Church.new
		@church.services.build
	end

	def create
		@church = Church.new(church_params)
		@church.user = current_user
		if @church.save
			flash[:success] = "Church created"
			redirect_to @church
		else
			flash.now[:danger] = "Unable to create church"
			render 'new'
		end
	end

	def edit
		@church = Church.find(params[:id])
	rescue
		flash[:danger] = "Unable to find church"
		redirect_to churches_path
	end

	def update
		@church = Church.find(params[:id])
		if @church.update(church_params)
			flash[:success] = "Your profile has been modified"
			redirect_to @church
		else
			flash[:danger] = "Unable to update profile"
			render 'edit'
		end
	end

	def destroy
		@church = Church.find(params[:id])
		@church.destroy
		flash[:success] = "#{@church.name} removed from the site"
		redirect_to churches_path
	end

	private

	def church_params
		params.require(:church).permit(:name,
			:web_site,
			:description,
			:picture,
			services_attributes: [:id,
														:day_of_week,
														:start_time,
														:finish_time,
														:location])
	end

	def ensure_user_logged_in
		unless current_user #If no user is logged in
			flash[:warning] = "Not logged in"
			redirect_to login_path
		end
  end

	def ensure_correct_user
		@church = Church.find(params[:id])
		@user = @church.user
		unless current_user?(@user) or current_user.admin? #If the user does not match the one logged in
			flash[:danger] = "Cannot edit other user's churches"
	    redirect_to root_path
		end
	rescue #If the church cannot be found
		flash[:danger] = "Unable to find church"
		redirect_to churches_path
  end
end