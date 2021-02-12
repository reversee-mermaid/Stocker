import { setArticle, setBtns } from '/res/js/module/common.js'

const slug = location.pathname.split('/').pop()
const currentFilter = document.querySelector(`.filter[data-slug="${slug}"]`)
currentFilter.classList.add('act')

const article = document.querySelector('#modal .article')
article.id = 'modal_inner'

modal.addEventListener('click', function(e) {
	if(e.target == this) toggleModal()
})

function toggleModal() {
	modal.classList.toggle('hide')
}

const thumbList = document.querySelectorAll('.thumb')
thumbList.forEach(thumb => {
	thumb.addEventListener('click', async function() {
		const {id} = this.dataset
		const {article, editable} = await getResponseJSON(id).then(json => json)
		
		setArticle(article)
		setBtns(article, editable)
		toggleModal()
	})
})

async function getResponseJSON(id) {
	return fetch(`/article/detail/thumb?id=${id}`).then(res => res.json())
}