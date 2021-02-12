import { setArticle, setBtns } from '/res/js/module/common.js'

function getId() {
	const url = new URL(location.href)
	const params = new URLSearchParams(url.search)
	return parseInt(params.get('id'))
}

async function getResponseJSON(id) {
	return fetch(`/article/detail/thumb?id=${id}`).then(res => res.json())
}

async function init() {
	const id = getId()
	const {article, editable} = await getResponseJSON(id).then(json => json)
	
	setArticle(article)
	setBtns(article, editable)
}

init()