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

    // 商品カードクリックで詳細ページへ遷移
    const cards = document.querySelectorAll(".clickable-card");
    cards.forEach(function(card) {
        card.addEventListener("click", function(e) {
            // カートボタンを押した場合は無視する
            if (e.target.tagName.toLowerCase() === "button" || e.target.closest("form")) {
                return;
            }

            const productId = card.getAttribute("data-id");
            if (productId) {
                // ★URLパターンに合わせる
                window.location.href = "/detail?id=" + productId;
                // もしControllerが /product/detail/{id} 形式なら↓
                // window.location.href = "/product/detail/" + productId;
            }
        });
    });
});
