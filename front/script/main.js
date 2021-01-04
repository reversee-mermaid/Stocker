function setModal(obj) {
    const modal_inner = document.getElementById('modal');
    modal_inner.innerHTML = `
        <img src="${obj.file_path}" alt="Image - ${obj.title}">
        <h2>${obj.title}</h2>
        <strong>${obj.author_name}</strong>
        <p>${obj.description}</p>
        <small>${obj.regdate}</small>
    `;
}

function createEl(obj) {
    const el = document.createElement('div');
    el.className = 'item';
    el.innerHTML = `
        <img src="${obj.file_path}" alt="open modal - ${obj.title}">
        <div>
            <strong>${obj.title}</strong>
            <small>${obj.author_name}</small>
        </div>
    `;

    el.onclick = function() {setModal(obj)}

    return el;
}

function init() {
    const container = document.getElementById('container');

    axios.get('./data.json')
        .then(function(res) {
            res.data.forEach(function(obj) {
                container.append(createEl(obj));
            })
        })
}

init();