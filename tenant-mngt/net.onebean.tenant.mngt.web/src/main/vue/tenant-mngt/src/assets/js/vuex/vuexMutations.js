let vuexMutations = {
  loadCurrentLoginUserInfo: async function(state, uagInfo) {
    state.uagCurrentLoginUserInfo = uagInfo
  },
  statusGlobalButtonLoding: async function(state) {
    state.globalButtonLoding = !state.globalButtonLoding
  },
  statusGlobalScreenLoding: async function(state) {
    state.globalScreenLoding = !state.globalScreenLoding
  }
}

export default vuexMutations
