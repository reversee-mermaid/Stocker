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
	const {tagList, title, caption, author_id, author_nm, regdate, file_nm} = data
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
				setBtn(el, src, file_nm)
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

function setBtn(el, src, file_nm) {
	unsetList(el)
	
	const download_btn = createEl('button', 'download_btn')
	const link = createEl('a', '')
	link.href = src
	link.download = file_nm
	link.append(createIconEl('download'))
	download_btn.append(link)
	
	const share_btn = createEl('button', 'share_btn')
	share_btn.append(createIconEl('share'))
	
	el.appendChild(download_btn)
	el.appendChild(share_btn)
}
