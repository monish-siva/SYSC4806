$(document).ready(function () {



    $.ajax({
        url: "http://localhost:8080/addressBook?id=1"
    }).then(function (data) {
        if (data) {
            $('.addressbook-id').append("Address Book ID: " + data.id);
            for (i = 0; i < data.contacts.length; i++) {
                $('.addressbook-contents').append("name: " + data.contacts[i].name + ", ").append("Phone Number: " + data.contacts[i].phoneNumber).append("<br>");
            }
        }
    });

    $(function() {
        $('#addNewBuddyForm').submit(function(e) {
            e.preventDefault();

            $.ajax({
                type: 'POST',
                url: '/buddy',
                data: $(this).serialize(),
                dataType    : 'json'

            }).then(function (data) {

                $('.addressbook-contents').append("name: " + data.name + ", ").append("Phone Number: " + data.phoneNumber).append("<br>");
            });

        });
    })









});




