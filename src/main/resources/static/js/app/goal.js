
//목표 리스트 테이블
var goals_table = document.getElementById('goals_table');
//성공 리스트 테이블
var success_table = document.getElementById('success_table');
//실패 리스트 테이블
var fail_table = document.getElementById('fail_table');

var main = {
    init: function () {
    var _this = this;
    $('#btn-add').on('click', function() {
        _this.add();
    });
    // list 설정
           new Sortable(goals_table, {
                ghostClass: 'goal-background-class',
                multiDrag: false, // Enable multi-drag
                group: 'shared', // set both lists to same group
                animation: 150,
                draggable: '.goal', //goal 클래스만 드래그 되도록 설정
                onAdd: function (/**Event*/evt) {//다른 리스트로부터 goal이 drop됐을 때 update
                    var itemEl = evt.item;
                    alert(itemEl.textContent+"add");
                },
                onRemove: function (/**Event*/evt) { //goal을 다른 리스트로 옮겨서 delete
                    var itemEl =evt.item;
                    alert(itemEl.textContent+"remove");
                },
            });

            new Sortable(success_table, {
                ghostClass: 'success-background-class',
                multiDrag: true, // Enable multi-drag
                group: 'shared',
                animation: 150,
                draggable: '.goal', //goal 클래스만 드래그 되도록 설정
                onAdd: function (/**Event*/evt) {//다른 리스트로부터 goal이 drop됐을 때 update
                    var itemEl = evt.item;
                    alert(itemEl.textContent+"add");
                },
                onRemove: function (/**Event*/evt) { //goal을 다른 리스트로 옮겨서 delete
                    var itemEl =evt.item;
                    alert(itemEl.textContent+"remove");
                },
            });

            new Sortable(fail_table, {
                ghostClass: 'fail-background-class',
                multiDrag: true, // Enable multi-drag
                group: 'shared',
                animation: 150,
                draggable: '.goal', //goal 클래스만 드래그 되도록 설정
                onAdd: function (/**Event*/evt) {//다른 리스트로부터 goal이 drop됐을 때 update
                    var itemEl = evt.item;
                    alert(itemEl.textContent+"add");
                },
                onRemove: function (/**Event*/evt) { //goal을 다른 리스트로 옮겨서 delete
                    var itemEl =evt.item;
                    alert(itemEl.textContent+"remove");
                },
            });
    },

//새로운 목표 추가
    add: function () {
    var goal = $('#new-goal').val();
    //빈 값 체크

    var div = document.createElement("div");
    div.innerHTML = goal;
    div.setAttribute('class', 'list-group-item goal');
    goals_table.appendChild(div);
    }
}
main.init();