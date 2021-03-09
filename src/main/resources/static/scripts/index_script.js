let search = function () {
    let input, filter, table, tr, td, i, txtValue;
    input = document.getElementById('search');
    filter = input.value.toLowerCase();
    table = document.getElementById('students_table');
    tr = table.getElementsByTagName('tr');

    for (i = 0; i < tr.length; i += 1) {
        td = tr[i].getElementsByTagName('td')[0];

        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toLowerCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}