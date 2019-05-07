package test.sumskar.com.mvp.presenter.SignUp

import test.sumskar.com.mvp.dto.SignUpdto

public interface SignUpPresenter {
    interface View{
        fun validateError(signUpdto: SignUpdto)
        fun signupsucess()
    }
    interface Presenter{
        fun doSignUp(signUpdto: SignUpdto,mView: View)
    }
}