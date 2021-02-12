export async function getResponseJSON(uri, init) {
	return fetch(uri, init).then(res => res.json())
}

export function getRequestInit(data) {
	if(data.constructor == FormData) {
		return {
			method: 'POST',
			body: data
		}
	}
	
	return {
		method: 'POST',
		headers: { 'content-type': 'application/json' },
		body: JSON.stringify(data)
	}
}
