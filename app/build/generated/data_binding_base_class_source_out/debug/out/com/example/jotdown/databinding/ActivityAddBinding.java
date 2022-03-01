// Generated by view binder compiler. Do not edit!
package com.example.jotdown.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.jotdown.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAddBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout adFrame;

  @NonNull
  public final FloatingActionButton btnAdd;

  @NonNull
  public final TextInputEditText edtEmail;

  @NonNull
  public final TextInputEditText edtName;

  @NonNull
  public final TextInputLayout textInputLayout3;

  private ActivityAddBinding(@NonNull ConstraintLayout rootView, @NonNull ConstraintLayout adFrame,
      @NonNull FloatingActionButton btnAdd, @NonNull TextInputEditText edtEmail,
      @NonNull TextInputEditText edtName, @NonNull TextInputLayout textInputLayout3) {
    this.rootView = rootView;
    this.adFrame = adFrame;
    this.btnAdd = btnAdd;
    this.edtEmail = edtEmail;
    this.edtName = edtName;
    this.textInputLayout3 = textInputLayout3;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAddBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAddBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_add, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAddBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      ConstraintLayout adFrame = (ConstraintLayout) rootView;

      id = R.id.btn_add;
      FloatingActionButton btnAdd = ViewBindings.findChildViewById(rootView, id);
      if (btnAdd == null) {
        break missingId;
      }

      id = R.id.edt_email;
      TextInputEditText edtEmail = ViewBindings.findChildViewById(rootView, id);
      if (edtEmail == null) {
        break missingId;
      }

      id = R.id.edt_name;
      TextInputEditText edtName = ViewBindings.findChildViewById(rootView, id);
      if (edtName == null) {
        break missingId;
      }

      id = R.id.textInputLayout3;
      TextInputLayout textInputLayout3 = ViewBindings.findChildViewById(rootView, id);
      if (textInputLayout3 == null) {
        break missingId;
      }

      return new ActivityAddBinding((ConstraintLayout) rootView, adFrame, btnAdd, edtEmail, edtName,
          textInputLayout3);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
