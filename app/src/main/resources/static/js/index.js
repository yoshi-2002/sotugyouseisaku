// HTML 読み込み後に実行
document.addEventListener("DOMContentLoaded", function() {

    // クリアボタン処理
    const clearBtn = document.getElementById('clearbutton');
    if (clearBtn) {
        clearBtn.addEventListener('click', function() {

            // こだわり検索フォームの input と select を全て取得
            const clearElements = document.querySelectorAll('#search-box input, #search-box select');
            clearElements.forEach(function(element) {
                if (element.tagName === 'INPUT') {
                    if (element.type === 'text' || element.type === 'number') {
                        element.value = ''; // 空文字にする
                    } else if (element.type === 'radio') {
                        element.checked = false; // ラジオボタンのチェックを外す
                    }
                } else if (element.tagName === 'SELECT') {
                    element.selectedIndex = 0; // 先頭を選択
                }
            });

            // ようこそ検索フォームの input もクリア
            const welcomeElements = document.querySelectorAll('#welcome-search-box input');
            welcomeElements.forEach(function(element) {
                if (element.tagName === 'INPUT' && element.type === 'text') {
                    element.value = '';
                }
            });

        });
    }

});
