document.addEventListener("DOMContentLoaded", function () {
    const username = localStorage.getItem("username") || "User";
    const role = localStorage.getItem("userRole") || "USER";

    // Update username
    const userNameSpan = document.getElementById("username");
    if (userNameSpan) {
        userNameSpan.textContent = username;
    }

    // Update role badge
    const roleBadge = document.getElementById("userRole");
    if (roleBadge) {
        if (role === "MANAGER" || role === "ADMIN") {
            roleBadge.textContent = "Manager";
            roleBadge.className = "role-badge role-manager";
        } else {
            roleBadge.textContent = "Customer";
            roleBadge.className = "role-badge role-user";
        }
    }

    // Show/hide role-based nav items
    if (role === "MANAGER" || role === "ADMIN") {
        document.querySelectorAll(".manager-only").forEach(el => {
            el.style.display = el.tagName === "LI" ? "list-item" : "block";
        });
    } else {
        document.querySelectorAll(".user-only").forEach(el => {
            el.style.display = el.tagName === "LI" ? "list-item" : "block";
        });
    }
    console.log("Navbar loaded. User:", username, "Role:", role);

});
