package com.krunal.brainvire.api.response

public class UserResponse {
    var results: ArrayList<UserRes> = ArrayList()

    public class UserRes {
        var gender: String = ""
        var email: String = ""
        var phone: String = ""
        var cell: String = ""
        var nat: String = ""
        var name: NameClass = NameClass()
        var picture: PictureClass = PictureClass()
        var location: LocationClass = LocationClass()
        var login: LoginClass = LoginClass()
        var dob: DobClass = DobClass()
        var registered: DobClass = DobClass()
        var id: IdClass = IdClass()

        class NameClass {
            var title: String = ""
            var first: String = ""
            var last: String = ""
        }

        class LocationClass {

            var street: StreetClass = StreetClass()

            class StreetClass {
                var number: String = ""
                var name: String = ""
            }

            var city: String = ""
            var state: String = ""
            var country: String = ""
            var postcode: String = ""
            var coordinates: CoordinatesClass = CoordinatesClass()
            var timezone: TimezoneClass = TimezoneClass()

            class CoordinatesClass {
                var latitude: String = ""
                var longitude: String = ""
            }

            class TimezoneClass {
                var offset: String = ""
                var description: String = ""
            }

        }

        class PictureClass {
            var large: String = ""
            var medium: String = ""
            var thumbnail: String = ""
        }

        class LoginClass {
            var uuid: String = ""
            var username: String = ""
            var password: String = ""
            var salt: String = ""
            var md5: String = ""
            var sha1: String = ""
            var sha256: String = ""
        }

        class DobClass {
            var date: String = ""
            var age: String = ""
        }

        class IdClass {
            var name: String = ""
            var value: String = ""
        }


    }


}