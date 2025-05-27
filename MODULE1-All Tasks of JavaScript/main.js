// JavaScript Basics
console.log("Welcome to the Community Portal");

function pageLoaded() {
  alert("Page fully loaded!");
}

// Phone Validation
function validatePhone(input) {
  const phoneRegex = /^[0-9]{10}$/;
  if (!phoneRegex.test(input.value)) {
    alert("Please enter a valid 10-digit phone number.");
  }
}

// Show Event Fee
function showFee() {
  const eventType = document.getElementById("eventType").value;
  const feeInfo = document.getElementById("feeInfo");
  const fees = { music: "$10", sports: "$5", tech: "$20" };
  feeInfo.textContent = `Fee: ${fees[eventType]}`;
}

// Confirm Submission
function confirmSubmit(event) {
  event.preventDefault();
  document.getElementById("confirmation").textContent = "Registration submitted!";
  savePreferences();
}

// Character Count
function countCharacters() {
  const message = document.getElementById("message").value;
  document.getElementById("charCount").textContent = `${message.length} characters`;
}

// Video Ready
function videoReady() {
  alert("Video ready to play");
}

// Enlarge Video
function enlargeVideo() {
  const video = document.getElementById("promoVideo");
  video.style.width = video.style.width === "100%" ? "300px" : "100%";
}

// Local Storage
function savePreferences() {
  const selectedEvent = document.getElementById("eventType").value;
  localStorage.setItem("preferredEvent", selectedEvent);
}

function clearPreferences() {
  localStorage.clear();
  sessionStorage.clear();
  alert("Preferences cleared.");
}

// Load preferences on start
window.onload = function () {
  const preferredEvent = localStorage.getItem("preferredEvent");
  if (preferredEvent) {
    document.getElementById("eventType").value = preferredEvent;
    showFee();
  }
}