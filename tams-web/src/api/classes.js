import { axios } from '@/util/request'

export const getClassesPage = (params) => {
  return axios({
    url: 'classes',
    method: 'get',
    params
  })
}

export const getClassesRefList = () => {
  return axios({
    url: 'classes/list/ref',
    method: 'get'
  })
}

export const getClassesById = (id) => {
  return axios({
    url: 'classes/' + id,
    method: 'get'
  })
}

export const saveClasses = (data) => {
  return axios({
    url: 'classes',
    method: 'post',
    data
  })
}

export const updateClassesById = (id, data) => {
  return axios({
    url: 'classes/' + id,
    method: 'put',
    data
  })
}

export const updateClassesEnableStateById = (id, enableState) => {
  return axios({
    url: 'classes/' + id + '/enable-state/' + enableState,
    method: 'put'
  })
}
