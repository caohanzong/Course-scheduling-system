import * as Api from '@/api/classes'

const classes = {
  state: {
  },
  mutations: {
  },
  actions: {
    GetClassesPage ({ commit }, param) {
      return new Promise((resolve, reject) => {
        Api.getClassesPage(param)
          .then(res => {
            resolve(res.data)
          })
          .catch(err => {
            reject(err)
          })
      })
    },
    GetClassesRefList ({ commit }) {
      return new Promise((resolve, reject) => {
        Api.getClassesRefList()
          .then(res => {
            resolve(res.data)
          })
          .catch(err => {
            reject(err)
          })
      })
    },
    GetClassesById ({ commit }, id) {
      return new Promise((resolve, reject) => {
        Api.getClassesById(id)
          .then(res => {
            resolve(res.data)
          })
          .catch(err => {
            reject(err)
          })
      })
    },
    SaveClasses ({ commit }, data) {
      return new Promise((resolve, reject) => {
        Api.saveClasses(data)
          .then(res => {
            resolve(res.data)
          })
          .catch(err => {
            reject(err)
          })
      })
    },
    UpdateClassesById ({ commit }, { id, data }) {
      return new Promise((resolve, reject) => {
        Api.updateClassesById(id, data)
          .then(res => {
            resolve(res.data)
          })
          .catch(err => {
            reject(err)
          })
      })
    },
    UpdateClassesEnableStateById ({ commit }, { id, enableState }) {
      return new Promise((resolve, reject) => {
        Api.updateClassesEnableStateById(id, enableState)
          .then(res => {
            resolve(res.data)
          })
          .catch(err => {
            reject(err)
          })
      })
    }
  }
}

export default classes
