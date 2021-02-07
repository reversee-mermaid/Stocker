modal.addEventListener('click', function(e) {
	if(e.target == this) toggleModal()
})	

const thumbList = document.querySelectorAll('.thumb')
thumbList.forEach(thumb => {
	thumb.addEventListener('click', async function() {
		const {id} = this.dataset;
		
		const data = await getResponseJSON(id).then(({article}) => article)
		
		setModal(data)
		toggleModal()
	})
})

async function getResponseJSON(id) {
	return fetch(`/article/detail/thumb?id=${id}`)
		.then(res => res.json())
}

function toggleModal() {
	modal.classList.toggle('hide')
}

function setModal(data) {
	const [el_tagList, el_title, el_caption, el_author, el_regdate, el_img, el_btn] =  modal_inner.children
	const {tagList, title, caption, author_nm, regdate, author_id, file_nm} = data
	
	while(el_tagList.hasChildNodes()) {
		el_tagList.removeChild(el_tagList.children[0])
	}

	tagList.forEach(tag => {
		const li = document.createElement('li')
		li.className = 'tag'
		li.innerText = tag.nm
		el_tagList.appendChild(li)
	})
	
	el_title.innerText = `Title: ${title}`
	el_caption.innerText = caption ? `Caption : ${caption}` : ''
	el_author.innerText = `Author: @${author_nm}`
	el_regdate.innerText = regdate
	
	const src = `/res/image/${author_id}/${file_nm}`
	el_img.src = src
	el_btn.querySelector('.download_btn > a').href = src
}