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