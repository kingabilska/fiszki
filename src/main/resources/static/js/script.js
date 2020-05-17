$(document).ready(function () {
    $('#pageSizeSelector').change(function () {
        window.location.replace("?size=" + this.value);
    })
})