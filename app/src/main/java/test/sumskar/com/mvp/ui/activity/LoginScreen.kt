package test.sumskar.com.mvp.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.login_activity.*
import test.sumskar.com.mvp.R
import test.sumskar.com.mvp.dto.SignUpdto
import test.sumskar.com.mvp.presenter.SignUp.SignUpPresenter
import test.sumskar.com.mvp.presenter.SignUp.SignUpPresenterImpl
import test.sumskar.com.mvp.ui.activity.home.HomeActivity

class LoginScreen : AppCompatActivity(), SignUpPresenter.View {

    var presenter: SignUpPresenter.Presenter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        initonjects()
    }

    private fun initonjects() {
        presenter= SignUpPresenterImpl()

        bt_submit.setOnClickListener {
            var signUp=signUpdtofun()
            presenter?.doSignUp(signUp,this)
        }
    }

    override fun signupsucess() {
        val intent=Intent(this,HomeActivity::class.java)
        startActivity(intent)

    }

    override fun validateError(signUpdto: SignUpdto) {
        Toast.makeText(this,"Please chheck Data",Toast.LENGTH_SHORT).show()
    }


    fun signUpdtofun():SignUpdto {
        var signUpdto=SignUpdto()
        signUpdto.setUsername(et_username.text.toString())
        signUpdto.setPassword(et_password.text.toString())
        signUpdto.setEmail(et_email.text.toString())
        return signUpdto
    }


}
