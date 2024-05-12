document.addEventListener("DOMContentLoaded", function() {
    const rows = document.querySelectorAll("tbody tr[data-id]");
    rows.forEach(row => {
        row.addEventListener("click", function() {
            rows.forEach(r => r.classList.remove("selected"));
            this.classList.add("selected");
        });
    });
});
