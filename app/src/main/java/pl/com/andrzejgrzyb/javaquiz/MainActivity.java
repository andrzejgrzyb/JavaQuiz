package pl.com.andrzejgrzyb.javaquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.question1_radiogroup) RadioGroup question1RadioGroup;
    @BindView(R.id.question2_checkBox1) CheckBox question2Checkbox1;
    @BindView(R.id.question2_checkBox2) CheckBox question2Checkbox2;
    @BindView(R.id.question2_checkBox3) CheckBox question2Checkbox3;
    @BindView(R.id.question2_checkBox4) CheckBox question2Checkbox4;
    @BindView(R.id.question3_radiogroup) RadioGroup question3RadioGroup;
    @BindView(R.id.question4_edittext) EditText question4EditText;
    @BindView(R.id.button) Button button;
    @BindView(R.id.result_textview) TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void checkResults() {
        int score = 0;
        if (question1RadioGroup.getCheckedRadioButtonId() == R.id.question1_radioButton3) {
            score++;
        }
        if (question2Checkbox1.isChecked() && !question2Checkbox2.isChecked() &&
                question2Checkbox3.isChecked() && question2Checkbox4.isChecked()) {
            score++;
        }
        if (question3RadioGroup.getCheckedRadioButtonId() == R.id.question3_radioButton1) {
            score++;
        }
        final String userAnswer4 = question4EditText.getText().toString();
        if (userAnswer4.equalsIgnoreCase(getResources().getString(R.string.question4_answer))) {
            score++;
        }
        setScore(score);
    }

    private void setScore(int score) {
        resultTextView.setText(getResources().getString(R.string.result_your_score, score));
    }
}
