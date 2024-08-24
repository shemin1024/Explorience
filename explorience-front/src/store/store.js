import { createStore } from "vuex";

export default createStore({
    state: {
        token: null,
    },
    mutations: {
        setToken(state, token) {
            state.token = token;
        },
        clearToken(state) {
            state.token = null;
            state.userInfo = null;
        },
        setUserInfo(state, userInfo) {
            state.userInfo = userInfo;
        }
    },
    actions: {
        saveToken({ commit }, token) {
            commit("setToken", token);
        },
        removeToken({ commit }) {
            commit("clearToken");
        },
        saveUserInfo({ commit }, userInfo) {
            commit('setUserInfo', userInfo);
        }
    },
    getters: {
        isAuthenticated: (state) => !!state.token,
        getToken: (state) => state.token,
        getUserInfo: state => state.userInfo,
    },
});
