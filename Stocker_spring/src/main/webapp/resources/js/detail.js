import { getParam } from '/res/js/module/common.js'
import { getResponseJSON } from '/res/js/module/request.js'
import { setArticle, setBtns } from '/res/js/module/common.js'

async function init() {
	const id = getParam('id')
	const uri = `/article/detail/thumb?id=${id}`
	const {article, editable} = await getResponseJSON(uri, null).then(json => json)
	
	setArticle(article)
	setBtns(article, editable)
}

init()