
//목표 리스트 테이블
var goals_table = document.getElementById('goals_table');
//성공 리스트 테이블
var success_table = document.getElementById('success_table');
//실패 리스트 테이블
var fail_table = document.getElementById('fail_table');

var main = {
    init: function () {
    var _this = this;
    // + 버튼 누르면 리스트 추가 생성
    $('#btn-add').on('click', function() {
        _this.add();
    });
    // 삭제 버튼 클릭시 리스트 제거
    $(document).on('click', '.delete',function() {
        _this.delete(this);
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
                    console.log(itemEl.getElementsByTagName('input')[0].value);
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
        var goal = $('#new-goal').val().trimStart().trimEnd();
        //빈 값 체크
        if(goal.length < 1) {
            alert("내용을 입력해주세요!");
            return;
        }

        //목표 저장
        $.ajax({
            url: '/goals',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify({"text": goal, "state": 'goal'})
        }).done(function(goal_id) {
        //리스트에 추가
            //리스트 DIV
            var listDiv = document.createElement("div");
            listDiv.innerText = goal;
            listDiv.className = 'list-group-item goal';

            //goal_id 삽입
            var id = document.createElement("input");
            id.type = 'hidden';
            id.value = goal_id;
            listDiv.appendChild(id);

            //버튼 감싸는 DIV
            var buttonDiv = document.createElement("div");
            buttonDiv.className = 'list-button';

            //버튼
            var button = document.createElement("button");
            button.type = 'button';
            button.innerHTML = '<i class="bi bi-trash-fill"></i>';
            button.className = 'btn btn-outline-danger delete';

            buttonDiv.appendChild(button);
            listDiv.appendChild(buttonDiv);
            goals_table.appendChild(listDiv);

        });
    },

    delete: function(obj) {
        obj.parentNode.parentNode.remove();
    }
}
main.init();