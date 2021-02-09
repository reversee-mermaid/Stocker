import { setArticle } from '/res/js/module/common.js'

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
		const data = await getResponseJSON(id).then(({article}) => article)
		
		setArticle(data)
		toggleModal()
	})
})

async function getResponseJSON(id) {
	return fetch(`/article/detail/thumb?id=${id}`).then(res => res.json())
}