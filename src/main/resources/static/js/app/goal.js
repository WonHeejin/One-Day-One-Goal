var example2Left = document.getElementById('example1');
var example2Right = document.getElementById('example2');
alert(example2Left);
new Sortable(example2Left, {
    group: 'shared', // set both lists to same group
    animation: 150
});

new Sortable(example2Right, {
    group: 'shared',
    animation: 150
});
