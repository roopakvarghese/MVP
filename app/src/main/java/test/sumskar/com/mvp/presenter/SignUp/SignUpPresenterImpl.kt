package test.sumskar.com.mvp.presenter.SignUp

import test.sumskar.com.mvp.dto.SignUpdto

class SignUpPresenterImpl: SignUpPresenter.Presenter {


    override fun doSignUp(signUpdto: SignUpdto,mView : SignUpPresenter.View) {
        val username=signUpdto.getUsername().trim()
        val password=signUpdto.getPassword().trim()
        val email=signUpdto.getEmail()

        if (username.equals("roopak")&& (password.equals("123"))) {
            mView.signupsucess()
        }else{
            mView.validateError(signUpdto)
        }
    }

}