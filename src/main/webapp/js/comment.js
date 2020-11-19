let comment = {
    requestComment(productId, limit) {
        let httpRequest = new XMLHttpRequest();

        httpRequest.addEventListener("load", function() {
<<<<<<< HEAD
            if (!error.alertRequestError(httpRequest.status)) {
                return;
            }

=======
>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e
            let comments = JSON.parse(httpRequest.responseText);
            comment.showComment(comments);
        })

        httpRequest.open("GET", "./api/comment?productId=" + productId + "&limit=" + limit, true);
        httpRequest.send();
    },

    showComment(comments) {
        let commentArea = document.querySelector(".list_short_review");

        let commentTemplate = document.querySelector("#shortReview").innerText;
        let bindTemplate = Handlebars.compile(commentTemplate);
        let commentText = "";

        if (!comments.length) {
            let moreReviewButton = document.querySelector(".btn_review_more");
            moreReviewButton.style.display = "none";

            return;
        }

        comments.forEach(element => {
            commentText += bindTemplate(element);
        })

        commentArea.innerHTML = commentText;
    },

    requestCommentInfo(productId) {
        let httpRequest = new XMLHttpRequest();

        httpRequest.addEventListener("load", function() {
<<<<<<< HEAD
            if (!error.alertRequestError(httpRequest.status)) {
                return;
            }

=======
>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e
            let commentInfo = JSON.parse(httpRequest.responseText);
            comment.showCommentInfo(commentInfo);
        })

        httpRequest.open("GET", "./api/comment/avg?productId=" + productId, true);
        httpRequest.send();
    },

    showCommentInfo(commentInfo) {
        commentCountArea = document.querySelector(".join_count>em");
        let commentCount = commentInfo.totalCount;
        commentCountArea.innerText = commentCount + "건";

        let commentAverageStar = document.querySelector(".graph_mask>em");
        let commentAverageArea = document.querySelector(".grade_area>.text_value>span");
        let commentAverage = commentInfo.average;
        let commentAveragePercent = (commentAverage / 5 * 100);

        commentAverageStar.style.width = commentAveragePercent + "%";
        commentAverageArea.innerText = commentAverage;
    }
}