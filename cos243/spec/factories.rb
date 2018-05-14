FactoryGirl.define do
	factory :user do
		sequence(:name) { |i| "User #{i}" }
		sequence(:email) { |i| "user.#{i}@example.com" }
		password 'password'
		password_confirmation 'password'

		factory :admin do
			admin true
		end
	end

	factory :church do
		sequence(:name) { |i| "Church #{i}" }
		sequence(:web_site) { |i| "http://church#{i}.org" }
		user
		transient { num_services 1 }

		after(:create) do |church, evaluator|
			create_list(:service, evaluator.num_services, church: church)
		end
	end

	factory :service do
		sequence(:day_of_week) { "Sunday" }
		sequence(:start_time) { "10:00 AM" }
		sequence(:finish_time) { "11:00 AM" }
		sequence(:location) { "Upland" }
		church
		transient { num_rides 1 }

		after(:create) do |service, evaluator|
			create_list(:ride, evaluator.num_rides, service: service)
		end
	end

	factory :ride do
		user
		service
		sequence(:number_of_seats) { 4 }
		sequence(:seats_available) { 4 }
		sequence(:meeting_location) { "Taylor University" }
		sequence(:vehicle) { "Saturn Vue" }
		sequence(:leave_time) { "9:45 AM" }
		sequence(:return_time) { "11:15 AM" }
		sequence(:date) { "2016-12-31" }
		transient { num_users 1 }

		after(:create) do |ride, evaluator|
			ride.users = create_list(:user, evaluator.num_users)
		end
	end

	factory :user_ride do
		user
		ride
	end
end
