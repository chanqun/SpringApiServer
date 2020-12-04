import Rating from "./module/rating.js"
import ReviewText from "./module/reviewText.js"
import ReviewImage from "./module/reviewImage.js";

document.addEventListener("DOMContentLoaded", () => {
    const productId = getParameterByName("productId");
    const reservationInfoId = getParameterByName("reservationInfoId");

    const ratingDiv = document.querySelector(".rating");
    const rankSpan = document.querySelector(".star_rank");
    const rating = new Rating(ratingDiv, rankSpan);

    const reviewWriteAnchor = document.querySelector(".review_write_info");
    const reviewTextArea = document.querySelector(".review_textarea");
    const textCountSpan = document.querySelector(".guide_review span");
    const reviewText = new ReviewText(reviewWriteAnchor, reviewTextArea, textCountSpan);

    const reviewImageInput = document.querySelector("#reviewImageFileOpenInput");
    const thumbnailImage = document.querySelector(".item_thumb");
    const deleteButton = document.querySelector(".lst_thumb .anchor");
    const reviewImage = new ReviewImage(reviewImageInput, thumbnailImage, deleteButton);

    document.querySelector(".bk_btn").addEventListener("click", () => {
        if (reviewText.validateTextCount()) {
            sendCommentFormData();
        } else {
            alert("글자수는 5자 이상 400자 이하입니다.");
        }
    })

    function sendCommentFormData() {
        let commentFormData = makeCommentFormData();

        let httpRequest = new XMLHttpRequest();

        httpRequest.addEventListener("load", function() {
            if (!error.alertRequestError(httpRequest.status)) {
                return;
            }

            alert("리뷰 등록을 성공하였습니다.");
            location.href = "./myreservation";
        })

        httpRequest.open("POST", "./api/reservations/" + reservationInfoId + "/comments", true);
        httpRequest.send(commentFormData);
    }

    function makeCommentFormData() {
        const commentFormData = new FormData();

        commentFormData.append("score", rating.score);
        commentFormData.append("comment", reviewText.reviewTextArea.value);
        commentFormData.append("imageFile", reviewImage.reviewImageInput.files[0]);
        commentFormData.append("productId", productId);

        return commentFormData;
    }
})