export function getParam(name) {
	const url = new URL(location.href)
	const params = new URLSearchParams(url.search)
	return parseInt(params.get(name))
}

export function setErrMessage(message) {
	const messageField = document.querySelector('.err_message')
	messageField.innerText = message
}

export function setArticle(data) {
	const article = document.querySelector('.article')

	Array.from(article.children).forEach(el => {
		switch (el.className) {
			case 'tag_list':
				unsetList(el)
				setTagList(el)
				break;

			case 'article_title':
				el.innerText = `Title: ${data.title}`
				break;

			case 'article_caption':
				el.innerText = data.caption ? `Caption: ${data.caption}` : ''
				break;

			case 'article_author':
				el.innerText = `Author: @${data.author_nm}`
				break;

			case 'article_regdate':
				el.innerText = data.regdate
				break;

			case 'article_img':
				el.alt = data.title
				el.src = `/res/image/${data.author_id}/${data.file_nm}`
				break;

			default:
				break;
		}
	})

	function unsetList(el) {
		while (el.hasChildNodes()) {
			el.removeChild(el.childNodes[0])
		}
	}

	function setTagList(el) {
		data.tagList.forEach(tag => {
			const li = document.createElement('li')
			li.className = 'tag'
			li.innerText = tag.nm
			el.appendChild(li)
		})
	}
}

export function setBtns(data, editable) {
	setCommonsBtns(data)
	setControlBtns(data.id, editable)
}

function setCommonsBtns(data) {
	const container = document.querySelector('.btn_container .commons')
	Array.from(container.children).forEach(btn => {
		switch (btn.className) {
			case 'download_btn':
				setDownloadBtn(btn)
				break;

			case 'share_btn':
				setShareBtn(btn)
				break;

			case 'fullscreen_btn':
				if (location.pathname == '/article/detail') {
					container.removeChild(btn)
				} else {
					setFullscreenBtn(btn)
				}
				break;

			default:
				break;
		}
	})
	
	function setDownloadBtn(btn) {
		const a = btn.querySelector('a')
		a.href = `/res/image/${data.author_id}/${data.file_nm}`
		a.download = data.file_nm
	}

	function setShareBtn(btn) {
		const tooltip = btn.querySelector('.tooltip')
		const current_message = tooltip.innerText

		btn.onclick = () => {
			console.log('copied')
			const text = `${location.origin}/article/detail?id=${data.id}`
			navigator.clipboard.writeText(text)
			tooltip.innerText = 'Copied !!'
		}

		btn.onmouseout = () => {
			tooltip.innerText = current_message
		}
	}

	function setFullscreenBtn(btn) {
		btn.onclick = () => {
			location.href = `/article/detail?id=${data.id}`
		}
	}
}

function setControlBtns(id, editable) {
	const container = document.querySelector('.btn_container .control')
	
	Array.from(container.children).forEach(btn => {

		if (!editable) {
			btn.onclick = null
			container.classList.add('hide')

		} else {
			switch(btn.className) {
				case 'delete_btn':
					btn.onclick = () => {
						if(confirm('Are you sure ??')) {
							location.href = `/article/delete?id=${id}`
						}
					}
					break
					
				case 'edit_btn':
					btn.onclick = () => {
						location.href = `/article/edit?id=${id}`
					}
					break
					
				default:
					break
			}
			container.classList.remove('hide')
		}
	})
}