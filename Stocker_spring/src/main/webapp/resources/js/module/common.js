export function setErrMessage(message) {
	const messageField = document.querySelector('.err_message')
	messageField.innerText = message
}

function createEl(tagName, className) {
	const el = document.createElement(tagName)
	el.className = className
	
	return el
}

function createIconEl(text) {
	const span = createEl('span', 'material-icons')
	span.innerText = text
	return span
}

export function setArticle(data) {
	const {id, tagList, title, caption, author_id, author_nm, regdate, file_nm} = data
	const src = `/res/image/${author_id}/${file_nm}`
	
	const article = document.querySelector('.article')
	Array.from(article.children).forEach(el => {
		switch(el.className) {
			case 'tag_list' : 
				setTagList(el, tagList)
				break
			case 'article_title' : 
				el.innerText = `Title: ${title}`
				break
			case 'article_caption' : 
				el.innerText = caption != '' ? `Caption: ${caption}` : ''
				break
			case 'article_author' : 
				el.innerText = `Author: @${author_nm}`
				break
			case 'article_regdate' :
				el.innerText = regdate
				break
			case 'article_img' : 
				el.src = src
				el.alt = title
				break
			case 'btn_container' :
				setBtn(el, id, src, file_nm)
				break
			default: break
		}
	})
}

function unsetList(el) {
	while(el.hasChildNodes()) {
		el.removeChild(el.childNodes[0])
	}
}

function setTagList(el, tagList) {
	unsetList(el)
	
	tagList.forEach(tag => {
		const li = createEl('li', 'tag')
		li.innerText = tag.nm
		el.appendChild(li)
	})
}

function setBtn(el, id, src, file_nm) {
	const download_btn = el.querySelector('.download_btn')
	const a = download_btn.querySelector('a')
	a.href = src
	a.download = file_nm
	
	const share_btn = el.querySelector('.share_btn')
	const tooltip = share_btn.querySelector('#tooltip')
	const current_message = tooltip.innerText
	
	share_btn.addEventListener('click', () => copyLink(id, tooltip))
	share_btn.addEventListener('mouseout', () => resetTooltip(tooltip, current_message))
//	share_btn.onmouseout = resetTooltip(tooltip, current_message)
}

function copyLink(id, tooltip) {
	const origin = location.origin
	navigator.clipboard.writeText(`${origin}/article/detail?id=${id}`)
	
	console.log(tooltip)
	tooltip.innerText = 'Copied !!'
}

function resetTooltip(tooltip, message) {
	tooltip.innerText = message
}










