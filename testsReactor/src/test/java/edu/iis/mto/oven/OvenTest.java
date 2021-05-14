package edu.iis.mto.oven;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;


@ExtendWith(MockitoExtension.class)


class OvenTest {
    @Mock
    HeatingModule heatingModule;
    @Mock
    Fan fan;

    @Test
    void itCompiles() {
        MatcherAssert.assertThat(true, equalTo(true));
    }


    @Test
    void runningOvenWithStaticProgramShouldBeSucccess(){

        ProgramStage stage1 = ProgramStage.builder()
                .withStageTime(30)
                .withHeat(HeatType.THERMO_CIRCULATION)
                .withTargetTemp(150)
                .build();

        List<ProgramStage> stageList= new ArrayList<>();
        stageList.add(stage1);

        BakingProgram bakingProgram = BakingProgram.builder()
                .withInitialTemp(0)
                .withStages(stageList)
                .build();

        Oven oven = new Oven(heatingModule, fan);
        oven.start(bakingProgram);

        }
}
