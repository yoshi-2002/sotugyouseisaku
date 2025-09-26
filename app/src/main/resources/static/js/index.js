document.addEventListener("DOMContentLoaded", function() {

    // クリアボタン処理（既存のまま）
    const clearBtn = document.getElementById('clearbutton');
    if (clearBtn) {
        clearBtn.addEventListener('click', function() {
            const clearElements = document.querySelectorAll('#search-box input, #search-box select');
            clearElements.forEach(function(element) {
                if (element.tagName === 'INPUT') {
                    if (element.type === 'text' || element.type === 'number') {
                        element.value = '';
                    } else if (element.type === 'radio') {
                        element.checked = false;
                    }
                } else if (element.tagName === 'SELECT') {
                    element.selectedIndex = 0;
                }
            });
            const welcomeElements = document.querySelectorAll('#welcome-search-box input');
            welcomeElements.forEach(function(element) {
                if (element.tagName === 'INPUT' && element.type === 'text') {
                    element.value = '';
                }
            });
        });
    }

    // 商品行クリックで詳細ページへ遷移
    const rows = document.querySelectorAll(".clickable-row");
    rows.forEach(function(row) {
        row.addEventListener("click", function() {
            const productId = row.getAttribute("data-id");
            if (productId) {
                window.location.href = "/detail?id=" + productId; // idに合わせる
            }
        });
    });
});
