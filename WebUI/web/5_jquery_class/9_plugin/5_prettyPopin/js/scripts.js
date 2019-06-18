/**
 * 
 */


$(function () {
    $('a[rel="prettyPopin"]:eq(0)').prettyPopin({
       width:550
    });
    $('a[rel="prettyPopin"]:eq(1)').prettyPopin({
        width:550,
        callback: func
    });
    function func() {
        alert('pop pop popup');
    }

}); // f end