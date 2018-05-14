class Ride < ActiveRecord::Base
  belongs_to :user
  belongs_to :service
	has_many :user_rides
	has_many :users, through: :user_rides

	validates :user, presence: true
	validates :service, presence: true
	validates :number_of_seats, presence: true
	validates :number_of_seats, numericality: { :greater_than_or_equal_to => 0, only_integer: true }
	validates :seats_available, presence: true
	validates :seats_available, if: :number_of_seats?, numericality: { :greater_than_or_equal_to => 0,
		:less_than_or_equal_to => :number_of_seats,
		only_integer: true }
	validates :meeting_location, presence: true
	validates :vehicle, presence: true
	validates :leave_time, presence: true
	validates :return_time, presence: true, date: { :after_or_equal_to => :leave_time }
	validates :date, presence: true
	validate :date_cannot_be_today, on: :create

	def date_cannot_be_today
		if date.present? && date <= Date.today
			errors.add(:date, "can't be today")
		end
	end
end
