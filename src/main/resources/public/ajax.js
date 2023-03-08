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

    $.ajax({
        url: "http://localhost:8080/user?id=1"
    }).then(function (data) {
        if (data) {
            $('.perk-id').append("Address Book ID: " + (this).serialize());
            /*for (i = 0; i < data.perks.length; i++) {
                $('.perk-contents').append("name: " + data.perks[i].location + ", ").append("Card: " + data.perks[i].card).append("membership: " + data.perks[i].membership).append("discount: " + data.perks[i].discount).append("<br>");
            }*/
        }
    });

    /*$(function() {
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
    })*/









});




