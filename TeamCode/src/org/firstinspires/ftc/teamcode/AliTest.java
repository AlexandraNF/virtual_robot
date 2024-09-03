package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="AliTest")

public class AliTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {


        int buttonPressCount = 0;
        boolean buttonPressed= false;

        DcMotor front_left = hardwareMap.dcMotor.get("front_left_motor");
        DcMotor front_right = hardwareMap.dcMotor.get("front_right_motor");
        DcMotor back_left = hardwareMap.dcMotor.get("back_left_motor");
        DcMotor back_right = hardwareMap.dcMotor.get("back_right_motor");

        // Reverse the motors on the left side
        front_left.setDirection(DcMotorSimple.Direction.REVERSE);
        back_left.setDirection(DcMotorSimple.Direction.REVERSE);


        waitForStart();

        while (opModeIsActive()) {

            double leftStickY = -gamepad1.left_stick_y;
            double leftStickX = gamepad1.left_stick_x;
            double triggers = gamepad1.left_trigger - gamepad1.right_trigger;

            // Set the power on the motors
            front_left.setPower(leftStickY + leftStickX - triggers);
            front_right.setPower(leftStickY - leftStickX + triggers);
            back_left.setPower(leftStickY - leftStickX - triggers);
            back_right.setPower(leftStickY + leftStickX + triggers);


            /* if (gamepad1.a) {
                buttonPressCount++;
            } */

            if (gamepad1.a && !buttonPressed){
                buttonPressed = true;
                buttonPressCount++;
            } else if (!gamepad1.a) {
                buttonPressed = false;
            }

            telemetry.addData("Left Stick Y", leftStickY);
            telemetry.addData("Press count", buttonPressCount);
            telemetry.addData("Press count boolean", buttonPressed);
            telemetry.update();

        }
    }
}
