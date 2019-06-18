/**
 *
 */


$(function () {
    $('#signup form').validate({
        rules: {
            name: {
                required: true
            },
            email: {
                required: true,
                email: true
            },
            website: {
                url: true
            },
            password: {
                required: true,
                minlength: 6
            },
            passconf: {
                equalTo: '#password'
            }
        },
        success: function (label) {
            label.addClass('valid');
        }
    }); // validate end


    // 전체 체크 박스
    $('#check-all').click(function () {

    /**  1 */
        if ($(this).prop('checked')) {
            $('.agree').prop('checked', true);
        } else $('.agree').prop('checked', false);

    /**  2 */
        // $('.agree').prop('checked', this.checked);

    /**  3 */
        // if ($(this).is(':checked')) {
        //     $('.agree').attr('checked', true);
        // } else $('.agree').attr('checked', false);

    }) // check all end


}); // f end