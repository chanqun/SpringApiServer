function getParameterByName(name) {
    let query = location.search.substr(1);
    let result = "";

    query.split("&").forEach(function(part) {
        let item = part.split("=");
        result[item[0]] = decodeURIComponent(item[1]);

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
});

Handlebars.registerHelper("formatEmail", function(email) {
    return email + "****";
});

Handlebars.registerHelper("formatTicketPrice", function(ticketPrice) {
    return ticketPrice.toLocaleString();
});

Handlebars.registerHelper("formatTicket", function(ticket) {
    switch (ticket) {
        case "A":
            return "성인 (만 19~64세)";
        case "B":
            return "유아 (만 4~12세)";
        case "Y":
            return "청소년 (만 13~18세)";
        case "S":
            return "20인 이상 단체";
        case "D":
            return "장애인";
        case "E":
            return "얼리버드";
        case "V":
            return "VIP";
    }

    return ticket + "석";
});