function getPreloader() {
	
	const loader = document.createElement('div')	
	loader.id = 'loader'
	
	const spin = document.createElement('div')
	spin.id = 'spin'
	
	const message = document.createElement('p')
	message.innerText = 'In progress...'
	
	loader.append(spin)
	loader.append(message)
	
	return loader;
}

export function setPreloader() {
	console.log('set preloader')
	document.body.prepend(getPreloader())
}

export function unsetPreloader() {
	console.log('unset preloader')
	document.body.removeChild(document.querySelector('#loader'))
}