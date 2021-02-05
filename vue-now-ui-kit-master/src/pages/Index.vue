<template>

  <div>
    
    <div class="page-header clear-filter" filter-color="orange">
      <parallax
        class="page-header-image"
        style="background-image:url('img/header.jpg')"
      >
      </parallax>
      <div class="container">
          
        <div class="content-center brand">
          <img class="n-logo" src="img/bisWhite.png" alt="" />
          <h1 class="h1-seo" style="font-weight:bold">아직까지 혼자 공부하세요?</h1>
          <h3>비스킷에서 전국 39291개의 스터디를 찾고 함께 공부하세요</h3>
          <div><i class="now-ui-icons arrows-1_minimal-down"></i></div>
        </div>
       
      </div>



      

      
    </div>


    <div class="main">
      <div class="section section-images">
        <div class="container">
          <div class="row">
            <div class="col-md-12">
              <div class="hero-images-container">
                <img src="img/Group 44.png" alt="" />
              </div>
            </div>

            <div class="col-md-12">
           
             
         
              <div class="hero-images-container-3">
                <h1 style="font-weight:bold">비대면 시대에도 편리하게 스터디.</h1>
                <div class="col-md-6">
                  <img class="container" src="img/bisBrown.png" alt="" />
                  </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    
  


<div><hr></div>
<br>





    <landing></landing>
    <carousel-section></carousel-section>
    <basic-elements></basic-elements>
    <navigation></navigation>
    <tabs-section></tabs-section>
    <progress-pagination></progress-pagination>
    <notifications></notifications>
    <typography></typography>
    <javascript-components></javascript-components>
    <carousel-section></carousel-section>
    <nucleo-icons-section></nucleo-icons-section>
    <div class="section">
      <div class="container text-center">
        <div class="row justify-content-md-center">
          <div class="col-md-12 col-lg-8">
            <h2 class="title">Completed with examples</h2>
            <h5 class="description">
              The kit comes with three pre-built pages to help you get started
              faster. You can change the text and images and you're good to go.
              More importantly, looking at them will give you a picture of what
              you can built with this powerful Bootstrap 4 ui kit.
            </h5>
          </div>
        </div>
      </div>
    </div>
    <signup-form></signup-form>
    <examples-section></examples-section>
    <download-section></download-section>
  </div>
</template>



<script>
import { Parallax } from '@/components';
import BasicElements from './components/BasicElementsSection';
import Navigation from './components/Navigation';
import TabsSection from './components/Tabs';
import ProgressPagination from './components/ProgressPagination';
import Notifications from './components/Notifications';
import Typography from './components/Typography';
import JavascriptComponents from './components/JavascriptComponents';
import CarouselSection from './components/CarouselSection';
import NucleoIconsSection from './components/NucleoIconsSection';
import SignupForm from './components/SignupForm';
import ExamplesSection from './components/ExamplesSection';
import Landing from './Landing.vue';

export default {
  name: 'index',
  bodyClass: 'index-page',
  components: {
    Parallax,
    BasicElements,
    Navigation,
    TabsSection,
    ProgressPagination,
    Notifications,
    Typography,
    JavascriptComponents,
    CarouselSection,
    NucleoIconsSection,
    SignupForm,
    ExamplesSection,
    Landing
  }
};


</script>





<style></style>
