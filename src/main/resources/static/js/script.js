$(document).ready(function () {
    $('.dropdown-item').on('click', function () {
        window.location.replace("?size=" + $(this).text());
    })
})