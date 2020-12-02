import Rating from "./module/rating.js"
import ReviewText from "./module/reviewText.js"
import ReviewImage from "./module/reviewImage.js";

document.addEventListener("DOMContentLoaded", () => {
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
})