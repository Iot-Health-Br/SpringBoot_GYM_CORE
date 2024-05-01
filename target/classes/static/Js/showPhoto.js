document.addEventListener('DOMContentLoaded', function() {
    var fotoInput = document.getElementById('file');
    var fotoPreview = document.getElementById('fotoPreview');

    fotoInput.addEventListener('change', function(event) {
        if (event.target.files && event.target.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
                fotoPreview.src = e.target.result;
                fotoPreview.style.display = 'block';
            };
            reader.readAsDataURL(event.target.files[0]);
        }
    });
});
