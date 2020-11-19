function getParameterByName(name) {
    let query = location.search.substr(1);
    let result = "";

    query.split("&").forEach(function(part) {
        let item = part.split("=");
        result[item[0]] = decodeURIComponent(item[1]);
<<<<<<< HEAD

=======
>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e
        if (item[0] === name) {
            result += decodeURIComponent(item[1]);
        }
    })

    return result;
}

Handlebars.registerHelper("formatScore", function(score) {
    return score.toFixed(1);
});

Handlebars.registerHelper("formatDate", function(date) {
    return moment(date).format("YYYY.MM.DD.");
<<<<<<< HEAD
});

Handlebars.registerHelper("formatEmail", function(email) {
    return email + "****";
=======
>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e
});