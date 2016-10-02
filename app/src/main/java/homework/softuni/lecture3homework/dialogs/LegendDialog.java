package homework.softuni.lecture3homework.dialogs;

import android.view.View;
import android.app.Dialog;
import android.view.Window;
import android.content.Context;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import homework.softuni.lecture3homework.R;

public class LegendDialog extends Dialog {
    public LegendDialog(Context context) {
        super(context);
    }

    @Override
    public void show() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//remove title bar
        setContentView(R.layout.dialog_legend);

        RelativeLayout root = (RelativeLayout) findViewById(R.id.root_legend);
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        ImageButton btnClose = (ImageButton) findViewById(R.id.dialog_close);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        super.show();
    }
}
