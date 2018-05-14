class UsersController < ApplicationController
	before_action :ensure_user_logged_in, only: [:edit, :update, :destroy]
	before_action :ensure_user_not_logged_in, only: [:create, :new]
	before_action :ensure_correct_user, only: [:edit, :update]
	before_action :ensure_admin, only: [:destroy]

	def index
		@users = User.all
	end

	def new
		@user = User.new
	end

	def create
		@user = User.new(user_params)

		if @user.save
			flash[:success] = "Welcome to the site, #{@user.name}"
			redirect_to @user
		else
			flash.now[:danger] = "Unable to create new user"
			render 'new'
		end
	end

	def show
		@user = User.find(params[:id])
	rescue
		flash[:danger] = "Unable to find user"
		redirect_to users_path
	end

	def edit
		@user = User.find(params[:id])
	rescue
		flash[:danger] = "Unable to find user"
		redirect_to users_path
	end

	def update
		@user = User.find(params[:id])
		if params.has_key?(:church_id)
			@user.church_id = params[:church_id]
			if @user.save
				flash[:success] = "Church attended"
			else
				flash[:danger] = "Unable to attend church"
			end
			redirect_to church_path(params[:church_id])
		else
			if @user.update(user_params)
				flash[:success] = "Your profile has been modified"
				redirect_to @user
			else
				flash[:danger] = "Unable to update profile"
				render 'edit'
			end
		end
	end

	def destroy
		@user = User.find(params[:id])
		@user.destroy
		flash[:success] = "#{@user.name} removed from the site"
		redirect_to users_path
	end

	private

	def user_params
		params.require(:user).permit(:name, :email, :password, :password_confirmation)
	end

	def ensure_user_logged_in
		unless current_user #If no user is logged in
			flash[:warning] = "Not logged in"
			redirect_to login_path
		end
  end

	def ensure_user_not_logged_in
		if current_user #If user is already logged in
			flash[:warning] = "Already logged in"
			redirect_to root_path
		end
  end

  def ensure_correct_user
		@user = User.find(params[:id])
		unless current_user?(@user) #If the user does not match the one logged in
	    flash[:danger] = "Cannot edit other user's profiles"
	    redirect_to root_path
		end
	rescue #If the user cannot be found
		flash[:danger] = "Unable to find user"
		redirect_to users_path
  end

  def ensure_admin
		@user = User.find(params[:id])
		if (current_user.id == @user.id) #If admin tries to delete himself
			flash[:danger] = 'Cannot delete yourself'
			redirect_to root_path
		else
			unless current_user.admin? #If the user is not admin
				flash[:danger] = 'Only admins allowed to delete users'
				redirect_to root_path
			end
		end
  end
end
