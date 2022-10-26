var example2Left = document.getElementById('example1');
var example2Right = document.getElementById('example2');
var example3 = document.getElementById('example3');

new Sortable(example2Left, {
    ghostClass: 'goal-background-class',
    multiDrag: true, // Enable multi-drag
	selectedClass: 'selected', // The class applied to the selected items
    group: 'shared', // set both lists to same group
    animation: 150,
    onMove(e) { //static 클래스가 아닌 요소들만 움직이도록
         return e.related.className.indexOf('static') === -1;
       }
});

new Sortable(example2Right, {
    ghostClass: 'success-background-class',
    multiDrag: true, // Enable multi-drag
	selectedClass: 'selected', // The class applied to the selected items
    group: 'shared',
    animation: 150,
    onMove(e) { //static 클래스가 아닌 요소들만 움직이도록
         return e.related.className.indexOf('static') === -1;
       }
});

new Sortable(example3, {
    ghostClass: 'fail-background-class',
    multiDrag: true, // Enable multi-drag
	selectedClass: 'selected', // The class applied to the selected items
    group: 'shared',
    animation: 150,
    onMove(e) { //static 클래스가 아닌 요소들만 움직이도록
         return e.related.className.indexOf('static') === -1;
       }
});